https://stackoverflow.com/questions/67395995/how-to-install-oracle-database-express-on-mac-m1

https://boisv.medium.com/oracle-database-express-edition-how-to-install-on-macos-538f6404fefb

```
docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle -v oracle-volume:/opt/oracle/oradata gvenzl/oracle-xe
```
