# Instalasi dan Konfigurasi JBoss EAP 7 #

* Jalankan JBoss EAP

```
./bin/standalone.sh
```

* Enable admin user

```
./bin/add-user.sh
```

Outputnya sebagai berikut

```
What type of user do you wish to add? 
 a) Management User (mgmt-users.properties) 
 b) Application User (application-users.properties)
(a): a

Enter the details of the new user to add.
Using realm 'ManagementRealm' as discovered from the existing property files.
Username : admin
User 'admin' already exists and is disabled, would you like to... 
 a) Update the existing user password and roles 
 b) Enable the existing user 
 c) Type a new username
```

Update password untuk user admin

```
(a): a
Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should be different from the username
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
Password : 
WFLYDM0098: The password should be different from the username
Are you sure you want to use the password entered yes/no? yes
Re-enter Password : 
What groups do you want this user to belong to? (Please enter a comma separated list, or leave blank for none)[PowerUser,BillingAdmin,]: 
Updated user 'admin' to file '/Users/endymuhardin/tmp/training-jee6/jboss-eap-7.4/standalone/configuration/mgmt-users.properties'
Updated user 'admin' to file '/Users/endymuhardin/tmp/training-jee6/jboss-eap-7.4/domain/configuration/mgmt-users.properties'
Updated user 'admin' with groups  to file '/Users/endymuhardin/tmp/training-jee6/jboss-eap-7.4/standalone/configuration/mgmt-groups.properties'
Updated user 'admin' with groups  to file '/Users/endymuhardin/tmp/training-jee6/jboss-eap-7.4/domain/configuration/mgmt-groups.properties'
Is this new user going to be used for one AS process to connect to another AS process? 
e.g. for a slave host controller connecting to the master or for a Remoting connection for server to server Jakarta Enterprise Beans calls.
yes/no? yes
To represent the user add the following to the server-identities definition <secret value="YWRtaW4=" />
```



* Browse ke management console : `http://localhost:9990/`