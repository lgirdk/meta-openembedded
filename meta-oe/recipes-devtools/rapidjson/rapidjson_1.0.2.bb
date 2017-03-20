SUMMARY = "A fast JSON parser/generator for C++ with both SAX/DOM style API"
HOMEPAGE = "http://rapidjson.org/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=cff54e417a17b4b77465198254970cd2"

SRC_URI = "git://github.com/miloyip/rapidjson.git;nobranch=1;protocol=http"

SRCREV = "3d5848a7cd3367c5cb451c6493165b7745948308"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DRAPIDJSON_BUILD_DOC=OFF -DRAPIDJSON_BUILD_TESTS=OFF -DRAPIDJSON_BUILD_EXAMPLES=OFF"

# RapidJSON is a header-only C++ library, so the main package will be empty.

FILES_${PN}-dev += "${libdir}/cmake"

BBCLASSEXTEND = "native nativesdk"
