import React, {useEffect, useState} from 'react';
import {HomeOutlined, LogoutOutlined, LaptopOutlined, BuildOutlined} from '@ant-design/icons';
import {Menu} from "antd";
import {Content} from "antd/es/layout/layout";
import ContentComponent from "./component/contentComponent";
import PatternsComponent from "./component/patternsComponent";

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
    getItem('Работа', 'work', <LaptopOutlined/>),
    getItem('Паттерны проектирования', 'patterns', <BuildOutlined/>),
    getItem('На главную', 'main', <LogoutOutlined/>)
];

const Theory = () => {

    const [key, setKey] = useState('');
    const [homePractice, setHomePractice] = useState([]);
    const [work, setWork] = useState([]);
    const [backGroundImage, setBackGroundImage] = useState('');

    const onMenuClick = (e) => {
        if (e.key === 'main') {
            return window.location.replace('http://localhost:3000/main');
        }

        if (e.key === key) {
            setKey('');
        } else {
            setKey(e.key);
        }

        if (e.key === 'patterns') {
            setBackGroundImage('')
        } else {
            setBackGroundImage(`url(${process.env.PUBLIC_URL + 'img/background_theory.jpg'})`)

        }
    }

    useEffect(() => {
        fetch('http://localhost:8080/theory/homePractice')
            .then((res) => res.json())
            .then((data) => {
                setHomePractice(data);
            })
            .catch((err) => {
                console.log(err.message);
            });
    }, []);

    useEffect(() => {
        fetch('http://localhost:8080/theory/work')
            .then((res) => res.json())
            .then((data) => {
                setWork(data);
            })
            .catch((err) => {
                console.log(err.message);
            });
    }, []);

    useEffect(() => {
        setBackGroundImage(`url(${process.env.PUBLIC_URL + 'img/background_theory.jpg'})`)
    }, [])

    return (
        <div style={{
            display: 'flex',
            flexDirection: 'row',
            backgroundImage: backGroundImage,
            backgroundPosition: 'center',
            backgroundSize: 'cover',
            backgroundRepeat: 'no-repeat',
            width: '100vw',
            height: '100vh',
            overflowY: 'auto',
            overflowX: 'hidden'
        }}
        >
            <Menu style={{height: '100vh', position: 'fixed'}}
                  onClick={(key) => onMenuClick(key)}
                  theme="dark"
                  items={items}/>
            <Content style={{marginLeft: '15.5%'}}>
                {key === 'homePractice' &&
                    <ContentComponent params={homePractice}/>
                }
                {key === 'work' &&
                    <ContentComponent params={work}/>
                }
                {key === 'patterns' &&
                    <PatternsComponent />
                }
            </Content>
        </div>
    )
}

export default Theory;
