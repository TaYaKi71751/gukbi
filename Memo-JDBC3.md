```java
// selectCustomerHobbys(){
DBConn.statementQuery("select customer.*,hobby.id as hobby_id,hobby.hobby from hobby,customer where customer.id = hobby.customer_id(+)"):
// }
```
```java
// deleteCustomerHobbys(Long customerId) {
DBConn.statementUpdate("delete from hobby where customer_id=" + customer_id);
DBConn.statementUpdate("delete from customer where id=" + customer_id);
// }
```
