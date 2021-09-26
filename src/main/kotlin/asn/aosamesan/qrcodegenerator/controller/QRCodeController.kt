package asn.aosamesan.qrcodegenerator.controller

import asn.aosamesan.qrcodegenerator.util.QRCodeUtil
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/generate")
class QRCodeController(private val qrCodeUtil: QRCodeUtil) {
    @GetMapping(path = ["/qrcode"], produces = ["image/png"])
    fun qrCode(@RequestParam(value = "text", required = true) text: String,
               @RequestParam(value = "width", defaultValue = "100") width: Int,
               @RequestParam(value = "height", defaultValue = "100") height: Int
    ): Mono<DataBuffer> {
        return qrCodeUtil.generateQRCode(text, width, height)
    }
}