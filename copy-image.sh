#!/bin/bash
# Script to copy image to clipboard using Java

cd /Users/Kesav/FIVECFLOW-Selenium-Automation

# Compile the CopyImageToClipboard class
javac -cp "target/classes:target/test-classes" CopyImageToClipboard.java

# Run it
java -cp ".:target/classes:target/test-classes" CopyImageToClipboard

# Clean up
rm CopyImageToClipboard.class

