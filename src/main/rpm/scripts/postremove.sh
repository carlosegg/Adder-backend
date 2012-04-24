#!/bin/bash

%{_log_postun_init}

if [ -d %{tomcat_home} ]; then

    rm -Rf %{tomcat_home}/work/*
    %{_do_check}

    rm -Rf %{tomcat_home}/temp/*
    %{_do_check}

    %{_log_postun_echo} %{name} uninstalled

else
    %{_log_postun_echo} Tomcat is uninstalled. Nothing to do.
fi


%{_log_postun_end}





