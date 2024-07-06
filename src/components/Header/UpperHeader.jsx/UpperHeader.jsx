import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'

const UpperHeader = () => {

    const [darkMode, setDarkMode] = useState(false);

    useEffect(() => {
        if (darkMode) {
            document.documentElement.classList.add("dark");
        } else {
            document.documentElement.classList.remove("dark");
        }
    }, [darkMode]);

    const toggleDarkMode = () => {
        setDarkMode(prevMode => !prevMode);
    };

    return (
        <div className='grid grid-cols-2 gap-1 sm:grid-cols-4 md:grid-cols-6 w-full uppercase py-1 px-2'>
            <Link to='/' className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs text-center px-3 py-2 ">राजस्थान सरकार</Link>
            <Link to='/' className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs px-3 py-2 md:col-span-3">Government of Rajasthan</Link>
            <Link to='/' className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs  px-3 py-2 text-center">Screen Access Reader</Link>
            <button onClick={toggleDarkMode} className="text-white bg-orange-500 hover:bg-orange-600 font-medium rounded text-xs px-3 py-2 text-center">
                Theme : {darkMode ? 'Dark' : 'Light'}
            </button>
        </div>
    )
}

export default UpperHeader
