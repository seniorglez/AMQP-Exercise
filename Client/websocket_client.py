import websocket
import json

def on_message(ws, message):
    print(f"Received message: {message}")

def on_open(ws):
    print("WebSocket connection opened")
    # Suscribirse al canal específico '/task'
    subscribe_message = json.dumps({"destination": "/task"})
    ws.send(subscribe_message)

# URL del servidor WebSocket
ws_url = "ws://localhost:8080/websocket"  # URL de la conexión WebSocket

# Crear una instancia del cliente WebSocket
ws = websocket.WebSocketApp(ws_url, on_message=on_message, on_open=on_open)

# Mantener la conexión WebSocket activa
ws.run_forever()

