import React from 'react';
import {Switch, Route}  from 'react-router-dom';
import Menu from './components/Menu';
import {About, AboutAmos, Home, Start} from './pages';

const App = () => {
    return (
        <div>
            <Menu/>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/about" component={About}/>
                <Route exact path="/aboutAmos" component={AboutAmos}/>
                <Route exact path="/start" component={Start}/>
            </Switch>
        </div>
    )
};

export default App;
