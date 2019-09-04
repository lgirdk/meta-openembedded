require lvm2.inc

SRCREV = "913c28917e62577a2ef67152b2e5159237503dda"

DEPENDS += "autoconf-archive-native"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    oe_runmake 'DESTDIR=${D}' -C libdm install
}

RRECOMMENDS_${PN}_append_class-target = " ${@bb.utils.contains('LVM2_PACKAGECONFIG', 'udev', 'lvm2-udevrules', '', d)}"

BBCLASSEXTEND = "native nativesdk"
