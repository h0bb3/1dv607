# About
Small experiment system to demonstrate the use of MVC supervising controller and passive view architecture. The controller can be reused across several very different views.
Views include a console based view, a AWT/SWING gui, and a websocket based ui (i.e you can connect a browser to it). Views can be run simultaneously.

You can start the application by using the corresponding main class:
* Main - console only view
* GUIMain - GUI view only
* ServerMain - Websocket view only
* MultiMain - All views


# Note
* Console view is probably quite windows console specific.
* Webbsocket view supports limited size text-messages only, it does not support ping/pong, close or binary messages. Check [src/view/websocket/Client.java](src/view/websocket/Client.java) that specifies the comunication protocol used.
* In general this is not how you develop an "optimal" system using websockets or GUIs it is an experiment
* There are probably bugs :D
