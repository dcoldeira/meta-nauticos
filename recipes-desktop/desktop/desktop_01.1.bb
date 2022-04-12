 
DESCRIPTION = "NauticOS"
AUTHOR = "dcoldeira"
LICENSE = "CLOSED"
PR = "r0"

SRC_URI =+ "file://desktop \
           "

DEPENDS += "qtbase qtdeclarative qtdeclarative-native"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${WORKDIR}/desktop ${D}/${bindir}/desktop

    lnr ${D}/${bindir}/desktop ${D}/${bindir}/b2qt
}

FILES_${PN} = "${bindir}/desktop \
               ${bindir}/b2qt \
