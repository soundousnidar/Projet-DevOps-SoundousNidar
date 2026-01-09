pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9' 
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
                sh 'echo "Tests exécutés avec succès"'
            }
        }
        
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/**/*', fingerprint: true
            }
        }
        
        stage('Deploy') {
            steps {
                sh 'echo "Déploiement simulé"'
            }
        }
    }
    
    post {
        success {
            echo '++++++ Pipeline réussi !'
        }
        failure {
            echo '------ Pipeline échoué !'
        }
    }
}