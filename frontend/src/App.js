import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { HomePage } from './pages/HomePage';
import { DiceGamePage } from './pages/DiceGamePage';
import { MinesGamePage } from './pages/MinesGamePage';
import { RouletteGamePage } from './pages/RouletteGamePage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/dice" element={<DiceGamePage />} />
        <Route path="/mines" element={<MinesGamePage />} />
        <Route path="/roulette" element={<RouletteGamePage />} />
      </Routes>
    </Router>
  );
}

export default App;