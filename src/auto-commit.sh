#!/bin/bash
#
# gitwait - watch file and git commit all changes as they happen
#

while true; do

  inotifywait -qq -e CLOSE_WRITE ~/Desktop/Tests/Java/Projects/CaptureTheFlag

  cd ~/Desktop/Tests/Java/Projects/CaptureTheFlag; git commit -a -m 'autocommit'

done
