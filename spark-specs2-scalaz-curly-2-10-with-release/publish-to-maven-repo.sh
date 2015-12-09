#!/bin/bash

releases_url=foo.bar

sbt -Dpublish.url=${releases_url} clean release 2>&1 | tee publish.log

echo "INFO: Checking if publish had error because sbt sucks and always gives 0 exit code"

errors=`cat publish.log | sed -r "s/\x1B\[([0-9]{1,2}(;[0-9]{1,2})?)?[mGK]//g" | grep "\[error\]"`

if [ "${errors}" != "" ]; then
    echo "INFO: Publish had errors, errors:"
    echo ${errors}
    exit 1
fi

exit 0
