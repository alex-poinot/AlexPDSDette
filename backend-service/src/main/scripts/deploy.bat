set m2=%M2_REPO%
set project=%PROJECT%
scp %m2%/edu/episen/si/ing1/pds/backend-service/1.0-SNAPSHOT/backend-service-1.0-SNAPSHOT-jar-with-dependencies.jar tata@172.31.249.148:/home/tata/Alex/
scp %project%/AlexPDSDette/backend-service/src/main/scripts/backend-service.sh tata@172.31.249.148:/home/tata/Alex/
ssh tata@172.31.249.148 chmod 777 /home/tata/Alex/backend-service.sh