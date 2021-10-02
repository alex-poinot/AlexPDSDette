PROJECT_PATH="${M2_REPO}/edu/episen/si/ing1/pds/backend-service/1.0-SNAPSHOT"
JAR_FILE="backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar"
CLASS_PATH=${PROJECT_PATH}/${JAR_FILE}
MAIN_CLASS="edu.episen.si.ing1.pds.backend.server.release2.Server"
#exec java -cp ${CLASS_PATH} ${MAIN_CLASS} $*
echo ${M2_HOME}
classpth="${M2_HOME}\\edu\\episen\\si\\ing1\\pds\\backend-service\\1.0-SNAPSHOT\\backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar"
exec java -cp /home/tata/Alex/backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar edu.episen.si.ing1.pds.backend.server.release2.Server $*


