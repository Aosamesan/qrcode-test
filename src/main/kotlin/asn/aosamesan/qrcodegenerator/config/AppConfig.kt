package asn.aosamesan.qrcodegenerator.config

import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
class AppConfig: WebFluxConfigurer {
    @Bean
    fun qrCodeWriter(): QRCodeWriter = QRCodeWriter()
}