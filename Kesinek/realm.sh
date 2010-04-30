#!/bin/sh

#1. instalace pluginu http://plugins.netbeans.org/PluginPortal/faces/PluginDetailPage.jsp?pluginid=8934 do NetBeans nebo je treba stahnout z JBoss.org RichFaces a dat do slozky lib a nastavit cestu

#2. Nastaveni Data Source
#	2.1 Vytvoreni databaze v JavaDB
#	2.2 V projektu KesinekBusinessLayer a v Configuration Files v persistence.xml vytvorit novy DataSource na napojeni na DB vytvorenou v predchozim kroku s jmenem KesinekDataSource

#3. Deploy a Run

asadmin create-auth-realm --property user-table=UserAccount --property user-name-column=username --property password-column=password --property group-table=UserRole --property group-name-column=name --property datasource-jndi=KesinekDataSource --property digest-algorithm=None --classname com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm KesinekRealm