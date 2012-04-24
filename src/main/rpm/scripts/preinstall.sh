#!/bin/bash

if [ ! -d %{_rpm_execution_log_dir} ]; then
    mkdir -p %{_rpm_execution_log_dir}
    %{_do_check}
    %{_log_pre_echo} %{_log_init} Creating log dir %{_rpm_execution_log_dir}

fi

%{_log_pre_init}

%{_log_pre_echo} Installing %{name}

%{_log_pre_end}
