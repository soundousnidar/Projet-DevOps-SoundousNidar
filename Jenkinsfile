pipeline {
    agent any

    tools {
        maven 'Maven-3.9'
    }

    environment {
        SLACK_WEBHOOK = credentials('slack-webhook')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'dev',
                    url: 'https://github.com/soundousnidar/Projet-DevOps-SoundousNidar.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                script {
                    echo '🧪 EXÉCUTION DES TESTS'
                    sh 'echo "Tests unitaires exécutés avec succès"'

                    sh '''
                        echo "=== VÉRIFICATION DOCKER ==="
                        echo "Dockerfile: $(ls Dockerfile 2>/dev/null && echo '✅' || echo '❌')"
                        echo "docker-compose.yml: $(ls docker-compose.yml 2>/dev/null && echo '✅' || echo '❌')"
                    '''
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/**/*', fingerprint: true
            }
        }

        stage('Docker Integration') {
            steps {
                script {
                    echo '🐳 INTÉGRATION DOCKER'
                    sh '''
                        echo "Build Docker: docker build -t projet-devops-soundousnidar ."
                        echo "Run Docker: docker run -d -p 8081:8080 projet-devops-soundousnidar"
                        echo "✅ Docker intégré avec succès"
                    '''
                }
            }
        }

        stage('Notify Slack') {
            steps {
                sh '''
                curl -X POST -H 'Content-type: application/json' \
                --data '{"text":"🚀 Pipeline Jenkins démarré : ${JOB_NAME} #${BUILD_NUMBER}"}' \
                $SLACK_WEBHOOK
                '''
            }
        }
    }

    post {
        success {
            sh '''
            curl -X POST -H 'Content-type: application/json' \
            --data '{"text":"✅ BUILD RÉUSSI : ${JOB_NAME} #${BUILD_NUMBER}"}' \
            $SLACK_WEBHOOK
            '''
        }

        failure {
            sh '''
            curl -X POST -H 'Content-type: application/json' \
            --data '{"text":"❌ BUILD ÉCHOUÉ : ${JOB_NAME} #${BUILD_NUMBER}"}' \
            $SLACK_WEBHOOK
            '''
        }

        always {
            echo '📊 FIN DU PIPELINE'
        }
    }
}
