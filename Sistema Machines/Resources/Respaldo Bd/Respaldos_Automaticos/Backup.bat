echo off
mysqldump -u root --password=#Maquinas@ --databases maquinas --opt --routines --add-drop-database --add-drop-table --complete-insert --create-options > Copia_de_Seguridad_%Date:~6,4%-%Date:~3,2%-%Date:~0,2%_%time:~0,2%-%time:~3,2%-%time:~6,2%.sql
exit

