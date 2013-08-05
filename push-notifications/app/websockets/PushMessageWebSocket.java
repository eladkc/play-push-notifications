package websockets;

import play.*;
import play.libs.F;
import play.mvc.*;

import views.html.*;
import views.html.index;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

public class PushMessageWebSocket extends WebSocket<String> {


    // Called when the Websocket Handshake is done.
    @Override
    public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out) {

      // For each event received on the socket,
      in.onMessage(new F.Callback<String>() {
         public void invoke(String event) {

           // Log events to the console
           println(event);
             System.out.println(event);

         }
      });

      // When the socket is closed.
      in.onClose(new F.Callback0() {
         public void invoke() {

           System.out.println("Disconnected");

         }
      });

      // Send a single 'Hello!' message
      out.write("Hello!");

    }
}
