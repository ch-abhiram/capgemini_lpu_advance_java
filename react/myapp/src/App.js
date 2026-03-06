import { useState } from "react";

function App() {
  const [msg, setMsg] = useState("");

  const callApi = async () => {
    const res = await fetch("http://localhost:8081/api/hello");
    const text = await res.text();
    setMsg(text);
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>CORS Demo</h2>
      <button onClick={callApi}>Call Spring API</button>
      <p>{msg}</p>
    </div>
  );
}

export default App;