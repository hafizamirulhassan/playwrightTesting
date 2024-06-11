pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        SELENIUM_REMOTE_URL = 'http://localhost:4444/wd/hub'
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/hafizamirulhassan/playwrightTesting.git'
                bat 'set SELENIUM_REMOTE_URL=http://localhost:4444/wd/hub'
                bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage("Deploy to QA") {
            steps {
                echo "deploy to qa"
            }
        }

        stage('Regression Automation Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    git 'https://github.com/hafizamirulhassan/playwrightTesting.git'
                    bat 'set SELENIUM_REMOTE_URL=http://localhost:4444/wd/hub'
                    bat 'mvn clean test -Dsurefire.suiteXmlFiles=testng.xml'
                }
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: false,
                             keepAll: true,
                             reportDir: 'build',
                             reportFiles: 'TestExecutionReport.html',
                             reportName: 'HTML Extent Report',
                             reportTitles: ''])
            }
        }
    }
}
