package asn.aosamesan.qrcodegenerator.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import reactor.core.publisher.Mono

@RequestMapping(path = ["", "/"])
@Controller
class QRCodeViewController() {
    @GetMapping("")
    fun index() = Mono.just("index")

    @GetMapping("/qrcode")
    fun qrCode(@RequestParam("text") text: String, model: Model): Mono<String> {
        model.addAttribute("text", text)
        return Mono.just("qrcode")
    }
}