import {Col, Row} from "antd";

const PatternsComponent = () => {
    return (
        <div>
            {/** Фабричный метод */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/factory_method/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={350} src={'patterns/factory_method/factory_method.jpg'}
                         alt={'factory_method'}></img>
                    <img width={600} height={350} src={'patterns/factory_method/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Абстрактная фабрика */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/abstract_factory/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={350} src={'patterns/abstract_factory/abstract_factory.jpg'}
                         alt={'abstract_factory'}></img>
                    <img width={600} height={350} src={'patterns/abstract_factory/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Строитель */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/builder/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={500} src={'patterns/builder/builder.jpg'} alt={'builder'}></img>
                    <img width={600} height={500} src={'patterns/builder/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Прототип */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/prototype/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={400} height={300} src={'patterns/prototype/prototype.jpg'} alt={'prototype'}></img>
                    <img width={400} height={300} src={'patterns/prototype/prototype_storage.jpg'}
                         alt={'prototype_storage'}></img>
                    <img width={400} height={300} src={'patterns/prototype/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Одиночка */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <img src={'patterns/singleton/name.jpg'} alt={'name'}></img>
            </Row>
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <img width={600} height={350} src={'patterns/singleton/singleton.jpg'} alt={'singleton'}></img>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Адаптер */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/adapter/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={350} height={300} src={'patterns/adapter/adapter_classes.jpg'} alt={'adapter_classes'}></img>
                    <img width={350} height={300} src={'patterns/adapter/adapter_objects.jpg'}
                         alt={'adapter_objects'}></img>
                    <img width={500} height={300} src={'patterns/adapter/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Мост */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/bridge/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={400} src={'patterns/bridge/bridge.jpg'} alt={'bridge'}></img>
                    <img width={600} height={400} src={'patterns/bridge/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Компоновщик */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/composite/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={500} src={'patterns/composite/composite.jpg'} alt={'composite'}></img>
                    <img width={600} height={500} src={'patterns/composite/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Декоратор */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/decorator/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={500} src={'patterns/decorator/decorator.jpg'} alt={'decorator'}></img>
                    <img width={600} height={500} src={'patterns/decorator/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Фасад */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/facade/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={350} src={'patterns/facade/facade.jpg'} alt={'facade'}></img>
                    <img width={600} height={350} src={'patterns/facade/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Легковес */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/flyweight/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={650} height={400} src={'patterns/flyweight/flyweight.jpg'} alt={'flyweight'}></img>
                    <img width={600} height={500} src={'patterns/flyweight/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Заместитель */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/proxy/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={450} src={'patterns/proxy/proxy.jpg'} alt={'proxy'}></img>
                    <img width={600} height={450} src={'patterns/proxy/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Цепочка обязанностей */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/chain_of_responsibility/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={600} height={550} src={'patterns/chain_of_responsibility/chain_of_responsibility.jpg'} alt={'chain_of_responsibility'}></img>
                    <img width={600} height={550} src={'patterns/chain_of_responsibility/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Команда */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/command/name.jpg'} alt={'name'}></img>
                </Col>
                <Col>
                    <img width={635} height={450} src={'patterns/command/command.jpg'} alt={'command'}></img>
                    <img width={635} height={550} src={'patterns/command/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Итератор */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/iterator/name.jpg'} alt={'name'}></img>
                </Col>
            </Row>
            <Row justify="space-evenly">
                <Col>
                    <img width={450} height={350} src={'patterns/iterator/iterator.jpg'} alt={'iterator'}></img>
                </Col>
                <Col>
                    <img width={450} height={450} src={'patterns/iterator/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Посредник */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/mediator/name.jpg'} alt={'name'}></img>
                </Col>
            </Row>
            <Row justify="space-evenly">
                <Col>
                    <img width={450} height={350} src={'patterns/mediator/mediator.jpg'} alt={'mediator'}></img>
                </Col>
                <Col>
                    <img width={450} height={350} src={'patterns/mediator/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Снимок */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/memento/name.jpg'} alt={'name'}></img>
                </Col>
            </Row>
            <Row justify="space-evenly">
                <Col>
                    <img width={350} height={300} src={'patterns/memento/memento1.jpg'} alt={'memento1'}></img>
                </Col>
                <Col>
                    <img width={350} height={300} src={'patterns/memento/memento2.jpg'} alt={'memento2'}></img>
                </Col>
                <Col>
                    <img width={350} height={300} src={'patterns/memento/memento3.jpg'} alt={'memento3'}></img>
                </Col>
            </Row>
            <br/>
            <br/>
            <Row justify="space-evenly">
                <Col>
                    <img width={350} height={300} src={'patterns/memento/example1.jpg'} alt={'example1'}></img>
                </Col>
                <Col>
                    <img width={350} height={100} src={'patterns/memento/example2.jpg'} alt={'example2'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Наблюдатель */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/observer/name.jpg'} alt={'name'}></img>
                </Col>
            </Row>
            <Row justify="space-evenly">
                <Col>
                    <img width={550} height={350} src={'patterns/observer/observer.jpg'} alt={'observer'}></img>
                </Col>
                <Col>
                    <img width={400} height={350} src={'patterns/observer/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

            <br/>
            <br/>
            <br/>
            <br/>

            {/** Состояние */}
            <Row style={{display: 'flex', justifyContent: 'center'}}>
                <Col>
                    <img src={'patterns/state/name.jpg'} alt={'name'}></img>
                </Col>
            </Row>
            <Row justify="space-evenly">
                <Col>
                    <img width={400} height={350} src={'patterns/state/state.jpg'} alt={'state'}></img>
                </Col>
                <Col>
                    <img width={400} height={300} src={'patterns/state/example.jpg'} alt={'example'}></img>
                </Col>
            </Row>

        </div>
    )
}

export default PatternsComponent;