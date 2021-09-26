package asn.aosamesan.qrcodegenerator.util

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.core.io.buffer.DataBuffer
import org.springframework.core.io.buffer.DefaultDataBufferFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.nio.charset.StandardCharsets

@Component
class QRCodeUtil(private val qrCodeWriter: QRCodeWriter) {
    fun generateQRCode(text: String, width: Int = 100, height: Int = 100): Mono<DataBuffer> {
        val resultText = String(text.toByteArray(StandardCharsets.UTF_8), Charsets.ISO_8859_1)
        val bitMatrix = qrCodeWriter.encode(resultText, BarcodeFormat.QR_CODE, width, height)
        return Mono.create { sink ->
            val buffer = DefaultDataBufferFactory.sharedInstance.allocateBuffer()
            buffer.asOutputStream().use {
                MatrixToImageWriter.writeToStream(bitMatrix, "png", it)
            }
            sink.success(buffer)
        }
    }
}