import './HomePage.css';
import { useNavigate } from 'react-router-dom';

export const HomePage = () => {
    const navigate = useNavigate();

    return (
    <div className="App">
        <div className="title-container">
          <h1>FAKE VEGAS</h1>
          <p className="subtitle">Your Ultimate Casino Experience</p>
        </div>
        <header className="App-header">
          <div className="button-container">
            <button className="game-button" onClick={() => navigate('/dice')}>
              <img src="/images/dice-icon.svg" alt="Dice" className="button-icon" />
              <span className="button-text">DICE</span>
            </button>
            <button className="game-button" onClick={() => navigate('/mines')}>
              <img src="/images/bomb-icon.svg" alt="Mines" className="button-icon" />
              <span className="button-text">MINES</span>
            </button>
            <button className="game-button" onClick={() => navigate('/roulette')}>
              <img src="/images/roulette-icon.svg" alt="Roulette" className="button-icon" />
              <span className="button-text">ROULETTE</span>
            </button>
          </div>
        </header>
    </div>
    )
}