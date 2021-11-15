pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
    }
    // Got permission denied while trying to connect to the Docker daemon socket at unix.
    // sudo usermod -a -G docker jenkins
    // restart jenkins server ->  sudo service jenkins restart
    stages {
        
        stage('Maven Compile') {
            steps {
                echo '----------------- This is a compile phase ----------'
                sh 'mvn clean compile'
            }
        }
        
         stage('Maven Test') {
            steps {
                echo '----------------- This is a compile phase ----------'
               
            }
        }
        
        stage('Maven Build') {
             steps {
                echo '----------------- This is a build phase ----------'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '----------------- This is a build docker image phase ----------'
                sh '''
                    docker image build -t ecomm-9 .
                '''
            }
        }

        stage('Docker Deploy') {
            steps {
                echo '----------------- This is a docker deploment phase ----------'
                sh '''
                 (if  [ $(docker ps -a | grep ecomm-9 | cut -d " " -f1) ]; then \
                        echo $(docker rm -f ecomm-9); \
                        echo "---------------- successfully removed ecomm-9 ----------------"
                     else \
                    echo OK; \
                 fi;);
            docker container run --restart always --name ecomm-9 -p 8081:8081 -d ecomm-9
            '''
            }
        }
    }
}
