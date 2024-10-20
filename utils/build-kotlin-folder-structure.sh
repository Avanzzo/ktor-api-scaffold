#!/bin/bash
set -euo pipefail

declare -r ROOT="$HOME/Projects/ktor-api-scaffold"
declare module=${1-"invalid path"}


if [ "$module" != "invalid path" ]; then
    # Rest of your commands go here
    declare -r module="$ROOT/$module"

if [ -d "$module" ]; then
    # Run your remaining commands here
    mkdir -p "$module/src/main/kotlin"
    mkdir -p "$module/src/main/resources"
    mkdir -p "$module/src/test/kotlin"
    mkdir -p "$module/src/test/resources"

else
    echo "Error: The provided path '$module' is not a valid folder."
    exit 1
fi
    
else
    echo "Path invalid"
    exit 1
fi
