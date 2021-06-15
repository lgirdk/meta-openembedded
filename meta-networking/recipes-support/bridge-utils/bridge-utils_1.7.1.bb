SUMMARY = "Tools for ethernet bridging"
HOMEPAGE = "http://www.linuxfoundation.org/collaborate/workgroups/networking/bridge"
SECTION = "net"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=f9d20a453221a1b7e32ae84694da2c37"

SRC_URI = "\
    https://mirrors.edge.kernel.org/pub/linux/utils/net/bridge-utils/bridge-utils-1.7.1.tar.gz \
    file://kernel-headers.patch \
    file://0005-build-don-t-ignore-CFLAGS-from-environment.patch \
    file://0006-libbridge-Modifying-the-AR-to-cross-toolchain.patch \
"

SRC_URI[md5sum] = "7296326fb8e00b875e7e75d25fe631e6"
SRC_URI[sha256sum] = "90bb0035eef5e9f842a239c6b01b7219e9f13786a92334f4984b7e3de97aabe2"

DEPENDS = "sysfsutils"

inherit autotools-brokensep update-alternatives

ALTERNATIVE_${PN} = "brctl"
ALTERNATIVE_PRIORITY[brctl] = "100"
ALTERNATIVE_LINK_NAME[brctl] = "${sbindir}/brctl"

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"

do_install_append () {
    install -d ${D}/${datadir}/bridge-utils
    install -d ${D}/${sysconfdir}/network/if-pre-up.d
    install -d ${D}/${sysconfdir}/network/if-post-down.d
}

RRECOMMENDS_${PN} = "kernel-module-bridge"
