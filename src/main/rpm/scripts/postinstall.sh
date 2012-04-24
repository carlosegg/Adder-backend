#!/bin/bash

%{_log_post_init}

%{_log_post} Starting tomcat
if [ "`/sbin/service tomcat6 status`" != "is running" ]; then
   /sbin/service tomcat6 start
fi
TOMCAT_PORT=8080
isRHFirewall=`cat /etc/sysconfig/iptables|grep "\-A RH-Firewall"`
if ! [ -z $isRHFirewall ]; then 
    ENABLED_TOMCAT_PORT=`cat /etc/sysconfig/iptables|grep "\-A RH-Firewall-1-INPUT -p tcp -m state --state NEW -m tcp --dport ${TOMCAT_PORT} -j ACCEPT"`
   if [ "$ENABLED_TOMCAT_PORT" == "" ]; then
      sed -i s:"-A RH-Firewall-1-INPUT -m state --state NEW -m tcp -p tcp --dport 22 -j ACCEPT":"-A RH-Firewall-1-INPUT -m state --state NEW -m tcp -p tcp --dport 22 -j ACCEPT\n-A RH-Firewall-1-INPUT -p tcp -m state --state NEW -m tcp --dport ${TOMCAT_PORT} -j ACCEPT":g /etc/sysconfig/iptables
      /sbin/service iptables restart
   fi
else 
   ENABLED_TOMCAT_PORT=`cat /etc/sysconfig/iptables|grep "\-A INPUT -p tcp -m state --state NEW -m tcp --dport ${TOMCAT_PORT} -j ACCEPT"`
   if [ "$ENABLED_TOMCAT_PORT" == "" ]; then
      sed -i s:" --dport 22 -j ACCEPT":" --dport 22 -j ACCEPT\n-A INPUT -p tcp -m state --state NEW -m tcp --dport ${TOMCAT_PORT} -j ACCEPT":g /etc/sysconfig/iptables
      /sbin/service iptables restart
   fi
fi

%{_log_post_end}

