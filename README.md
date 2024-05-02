# Training Java EE 6 #

Generate project dengan Maven

1. Jalankan `mvn archetype:generate`

2. Filter dengan keyword `javaee6`

    Hasilnya sebagai berikut

    ```
Choose archetype:
1: remote -> com.sap.cloud.s4hana.archetypes:scp-neo-javaee6 (Archetype for a project based on Java EE 6 on SAP Cloud Platform (Neo).)
2: remote -> com.sap.cloud.s4hana.starters:scp-neo-javaee6 (Starter for a project based on Java EE 6 on SAP Cloud Platform (Neo).)
3: remote -> de.akquinet.jbosscc:jbosscc-javaee6-modular-ear-archetype (Maven Archetype to generate a modular Java EE 6 based project skeleton.)
4: remote -> org.codehaus.mojo.archetypes:appclient-javaee6 (Archetype for an Application Client package using Java EE 6.)
5: remote -> org.codehaus.mojo.archetypes:ear-javaee6 (Archetype for EAR package using Java EE 6)
6: remote -> org.codehaus.mojo.archetypes:ejb-javaee6 (Archetype for an EJB package using Java EE 6.)
7: remote -> org.codehaus.mojo.archetypes:webapp-javaee6 (Archetype for a web application using Java EE 6.)
8: remote -> org.jboss.archetype.eap:jboss-javaee6-webapp-archetype (An archetype that generates a starter Java EE 6 webapp project for JBoss EAP 6)
    ```

3. Pilih nomor `6`

4. Masukkan nama package dan informasi lain seperti ini

   ```
Choose org.codehaus.mojo.archetypes:ejb-javaee6 version: 
1: 1.0
2: 1.0.1
3: 1.0.2
4: 1.1
5: 1.2
6: 1.3
7: 1.4
8: 1.5
Choose a number: 8: 
Define value for property 'groupId': com.muhardin.endy.training.jee6
Define value for property 'artifactId': toko-ejb
Define value for property 'version' 1.0-SNAPSHOT: : 
Define value for property 'package' com.muhardin.endy.training.jee6: : 
Confirm properties configuration:
groupId: com.muhardin.endy.training.jee6
artifactId: toko-ejb
version: 1.0-SNAPSHOT
package: com.muhardin.endy.training.jee6
   ```

5. Perintah untuk build : `mvn clean package`


# Referensi #

* [Berbagai strategi mapping inheritance](https://thorben-janssen.com/complete-guide-inheritance-strategies-jpa-hibernate/)
* [JBoss EAP 6 Developer Guide](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html/development_guide/index)
* [JBoss EAP 7 Developer Guide](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html/development_guide/index)
* [Struktur Multi Module Maven EAR](https://github.com/StefanHeimberg/stackoverflow-1134894)