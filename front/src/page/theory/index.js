import React from 'react';
import {HomeOutlined} from '@ant-design/icons';
import {Menu} from 'antd';
import HomePractice from "./component/homePractice";
import {Route, Routes, useNavigate} from "react-router-dom";


function getItem(label, key, icon, children) {
    return {
        key,
        icon,
        children,
        label,
    };
}

const items = [
    getItem('Домашняя практика', 'homePractice', <HomeOutlined/>),
];

const Theory = () => {
    const navigate = useNavigate();

    return (
        <div style={{
            display: 'flex',
            flexDirection: 'row',
            backgroundImage: `url(${process.env.PUBLIC_URL + 'img/background_theory.jpg'})`,
            backgroundPosition: 'center',
            backgroundSize: 'cover',
            backgroundRepeat: 'no-repeat',
            width: '100vw',
            height: '100vh'
        }}>
            <Menu
                // onClick={({key}) => navigate(key)}
                theme="dark"
                items={items}
            ></Menu>
            <Content/>
        </div>
    )
}

function Content() {
    return (
        <div>
            <Routes>
                <Route path="homePractice" element={<div>Hello</div>}/>
            </Routes>
        </div>
    )
}


// <Layout
//     style={{
//         minHeight: '100vh',
//     }}
// >
//     <Sider collapsible collapsed={collapsed} onCollapse={(value) => setCollapsed(value)}>
//         <div className="demo-logo-vertical"/>
//
//     </Sider>
//     <Layout style={{
//         backgroundImage: `url(${process.env.PUBLIC_URL + 'img/background_theory.jpg'})`,
//         backgroundPosition: 'center',
//         backgroundSize: 'cover',
//         backgroundRepeat: 'no-repeat',
//         width: '100vw',
//         height: '100vh'
//     }}>
//         <Content>
//             <Routes>
//                 <Route path="homePractice" element={<HomePractice/>}/>
//             </Routes>
//         </Content>

//     </Layout>
// </Layout>

// <div
//     style={{
//         textAlign: 'right',
//         paddingRight: '10%'
//     }}
// >
//     <a href="/">Вернуться на главную страницу</a>
// </div>
export default Theory;