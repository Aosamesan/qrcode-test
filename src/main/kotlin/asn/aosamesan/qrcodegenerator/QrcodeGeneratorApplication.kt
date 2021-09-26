package asn.aosamesan.qrcodegenerator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QrcodeGeneratorApplication

fun main(args: Array<String>) {
	runApplication<QrcodeGeneratorApplication>(*args)
}
