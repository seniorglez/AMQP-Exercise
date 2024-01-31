import asyncio
import websockets

async def connect_to_websocket_server():
    server_url = "ws://localhost:8080/path/task"

    async with websockets.connect(server_url) as websocket:
        print("Conexión establecida con éxito")

        while True:
            message = await websocket.recv()
            print(f"Mensaje recibido: {message}")

if __name__ == "__main__":
    asyncio.get_event_loop().run_until_complete(connect_to_websocket_server())
