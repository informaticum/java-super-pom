#!/bin/bash

echo "Calling this script causes some maven error messages. This is because of
a known bug within the versions-maven-plugin:
- https://stackoverflow.com/questions/29344809/versionsdisplay-plugin-updates-does-not-understand-maven-enforcer-plugin
- https://web.archive.org/web/20150514123930/http://jira.codehaus.org/browse/MVERSIONS-272
- https://github.com/mojohaus/versions-maven-plugin/issues/48

Thus, temporarily add the following section into the POM to suppress these
messages:
    <prerequisites>
      <maven>3.0</maven>
    </prerequisites>

Admittedly, this causes a different warning appearing instead."

mvn org.codehaus.mojo:versions-maven-plugin:2.5:display-parent-updates     > parent-updates.log
mvn org.codehaus.mojo:versions-maven-plugin:2.5:display-plugin-updates     > plugin-updates.log
mvn org.codehaus.mojo:versions-maven-plugin:2.5:display-dependency-updates > dependency-updates.log
mvn org.codehaus.mojo:versions-maven-plugin:2.5:display-property-updates   > property-updates.log
