import React from "react";
import {Route, Routes} from "react-router-dom";
import Main from "./page/main";
import Theory from "./page/theory";

function App() {
    return (
        <>
            <Routes>
                <Route path="/" element={<Main/>}/>
                <Route path="/theory" element={<Theory/>}/>
            </Routes>
        </>
    )
}

export default App;
