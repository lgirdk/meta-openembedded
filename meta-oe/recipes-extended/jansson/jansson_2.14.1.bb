SUMMARY = "Jansson is a C library for encoding, decoding and manipulating JSON data"
HOMEPAGE = "http://www.digip.org/jansson/"
BUGTRACKER = "https://github.com/akheron/jansson/issues"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9911525d4128bee234ee2d3ccaa2537"

SRC_URI = "https://github.com/akheron/${BPN}/releases/download/v${PV}/${BP}.tar.bz2"
SRC_URI[sha256sum] = "6bd82d3043dadbcd58daaf903d974891128d22aab7dada5d399cb39094af49ce"

UPSTREAM_CHECK_URI = "https://github.com/akheron/${BPN}/releases"
UPSTREAM_CHECK_REGEX = "${BPN}-(?P<pver>\d+(\.\d+)+)\.tar"

inherit autotools pkgconfig

# upstream considers it isn't a real bug https://github.com/akheron/jansson/issues/548
CVE_CHECK_IGNORE = "CVE-2020-36325 "

BBCLASSEXTEND = "native"
