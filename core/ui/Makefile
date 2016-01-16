#copyright Lesbonne.inc
#author yucheng
#since 1
#This Makefile is used for Ui Server
ifndef REMOTE
REMOTE =
else
REMOTE := $(USER)-$(REMOTE)
endif

PROJECT_NAME := Lesbonne $(REMOTE)
.SILENT:
.PHONY: help
help:
	printf "PROJECT_NAME:"$(PROJECT_NAME)""
	printf "\n"
	printf "Available Commands\n"
	printf "Arguments in parentheses. '?' specifies optional parameter \n"
	awk '/^[a-zA-Z\-\_0-9]+:/ { \
		helpMessage = match(lastLine, /^## (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")); \
			helpMessage = substr(lastLine, RSTART + 3, RLENGTH); \
			printf "\033[36m%-20s \033[0m%s\n", helpCommand, helpMessage; \
		} \
	} \
	{ lastLine = $$0 }' $(MAKEFILE_LIST)

## install dependencies
install:
	# ui install
	npm install

## start webpack dev server
serve_packs:
	npm run dev-pack-server

## build webpack bunlde.js
build:
	npm run prod-pack
	