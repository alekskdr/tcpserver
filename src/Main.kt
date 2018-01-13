import java.net.ServerSocket
import java.util.*
import java.awt.Robot
import java.awt.event.KeyEvent

fun main(args : Array<String>){

    Thread({

        val server = ServerSocket(4444)
        println("Server running on port ${server.localPort}")

        val r = Robot()

        while (true) {

            val client = server.accept()
            println("Client conected : ${client.inetAddress.hostAddress}")

            val scanner = Scanner(client.inputStream)
            while (scanner.hasNextLine()) {
                val message = scanner.nextLine()

                if (message != null) {
                    if (message == "shift_left") {
                        println("shift_left")
                        r.keyPress(KeyEvent.VK_CONTROL)
                        r.keyPress(KeyEvent.VK_LEFT)
                        r.keyRelease(KeyEvent.VK_LEFT)
                        r.keyRelease(KeyEvent.VK_CONTROL)
                    }
                    else if (message == "shift_right") {
                        println("shift_right")
                        r.keyPress(KeyEvent.VK_CONTROL)
                        r.keyPress(KeyEvent.VK_RIGHT)
                        r.keyRelease(KeyEvent.VK_RIGHT)
                        r.keyRelease(KeyEvent.VK_CONTROL)
                    }
                    else if (message == "left") {
                        println("left")
                        r.keyPress(KeyEvent.VK_LEFT)
                        r.keyRelease(KeyEvent.VK_LEFT)
                    }
                    else if (message=="right") {
                        println("right")
                        r.keyPress(KeyEvent.VK_RIGHT)
                        r.keyRelease(KeyEvent.VK_RIGHT)
                    }
                    else if (message=="up") {
                        println("up")
                        r.keyPress(KeyEvent.VK_PAGE_UP)
                        r.keyRelease(KeyEvent.VK_PAGE_UP)
                    }
                    else if (message=="down") {
                        println("down")
                        r.keyPress(KeyEvent.VK_PAGE_DOWN)
                        r.keyRelease(KeyEvent.VK_PAGE_DOWN)
                    }
                    else if (message=="vk_up") {
                        println("button up")
                        r.keyPress(KeyEvent.VK_UP)
                        r.keyRelease(KeyEvent.VK_UP)
                    }
                    else if (message=="vk_down") {
                        println("button down")
                        r.keyPress(KeyEvent.VK_DOWN)
                        r.keyRelease(KeyEvent.VK_DOWN)
                    }
                    else if (message=="enter") {
//                        println("enter")
                        r.keyPress(KeyEvent.VK_ENTER)
                        r.keyRelease(KeyEvent.VK_ENTER)
                    }
                    else if (message=="space") {
                        println("space")
                        r.keyPress(KeyEvent.VK_SPACE)
                        r.keyRelease(KeyEvent.VK_SPACE)
                    }
                }
            }

            scanner.close()
            client.close()
        }

        server.close()

    }).start()

}