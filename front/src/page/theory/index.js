import React, {useState} from 'react';
import {HomeOutlined, LogoutOutlined} from '@ant-design/icons';
import {Menu} from "antd";
import {Content} from "antd/es/layout/layout";
import HomePractice from "./component/homePractice";

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
    getItem('На главную', 'main', <LogoutOutlined/>)
];

const Theory = () => {

    const [key, setKey] = useState('');

    const onMenuClick = (e) => {
        if (e.key === 'main') { return window.location.replace('http://localhost:3000/'); }
        if (e.key === key) {
            setKey('');
        } else {
            setKey(e.key);
        }
    }

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
        }}
        >
            <Menu
                onClick={(key) => onMenuClick(key)}
                theme="dark"
                items={items}/>
            <Content>
                {key === 'homePractice' && <HomePractice/>}
            </Content>
        </div>
    )
}

export default Theory;
