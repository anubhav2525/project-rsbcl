import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { RouterProvider } from 'react-router-dom'
import { withoutAuthRoute } from './routers/withoutAuthRoute.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={withoutAuthRoute} />
  </React.StrictMode>
)
