// import { useEffect } from 'react';
import { memo } from 'react';
import { BrowserRouter, useRoutes, useLocation, Navigate } from 'react-router-dom';
// import { Provider } from 'react-redux';
import { Provider, useSelector } from 'react-redux';
import { PersistGate } from 'redux-persist/integration/react';
import { store, persistor } from 'redux/store';
// import requestPermission from './firebase/firebase-messaging';

import View from 'layouts/View';

import Login from 'reacts/pages/Login';
import Ground from 'reacts/pages/Ground';
import GroundCheck from 'layouts/GroundCheck';

import { Global } from 'reacts/styles/Global';

const Routing = memo(() => {
  // useEffect(() => {
  //   // navigator.serviceWorker.register('/firebase-messaging-sw.js').then((registration) => {
  //   //   console.log('Service Worker registered with scope:', registration.scope);

  //   //   // Wait for the service worker to become ready
  //   //   return navigator.serviceWorker.ready;
  //   // });

  //   requestPermission();
  // }, []);
  const location = useLocation();
  const user = useSelector((state) => state.user);

  const routes = useRoutes([
    {
      path: '/login/*',
      element: <Login />,
    },
    {
      path: '/',
      element: user.lastGround === null || user.lastGround === 'null' ? <Navigate to="/login/groundinit" /> : <Navigate to={`/${user.lastGround}`} />,
    },
    {
      path: '/:groundId/*',
      element: <GroundCheck />,
    },
    { path: '/newground', element: <Ground /> },
  ]);

  const nocheck = ['/login', '/login/github'];
  return user.isLoggedIn ? (
    location.pathname === '/login' ? (
      <Navigate to={`/${user.lastGround}`} />
    ) : (
      routes
    )
  ) : nocheck.includes(location.pathname) ? (
    routes
  ) : (
    <Navigate to="/login" />
  );
});

const App = () => {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <Global />
        <BrowserRouter forceRefresh>
          <View>
            <Routing />
          </View>
        </BrowserRouter>
      </PersistGate>
    </Provider>
  );
};

export default App;
