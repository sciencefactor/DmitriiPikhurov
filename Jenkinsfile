#!/usr/bin/env groovy

pipeline {
    agent any

    parameters {
        choice(name: 'ENV_CHOICE', choices: ['dev', 'release'])
    }

    stages {
        stage('Test') {
            steps {
                sh "mvn clean"
                sh "test -P selenium-homework4-failing"
            }
        }
    }

    post {
        always {
            allure commandline: 'allure2-13-2',
                    includeProperties: false,
                    jdk: '',
                    report: 'target/allure-report',
                    results: [[path: 'target/test-results/allure-results']]
        }
//        unstable {
//            script {
//                if (params.SEND_REPORT == true) {
//                    echo "Sending test report..."
//                    mail to: 'dmitrii_pikhurov@epam.com', subject: "AgileS Test Automation CI job - Unstable pipeline",
//                        body: "AgileS Test Automation job - ${currentBuild.fullDisplayName}.\nEnvironment - $ENV_CHOICE\nBuild unstable, see allure report ${env.BUILD_URL}allure/"
//                }
//            }
//        }
    }
}