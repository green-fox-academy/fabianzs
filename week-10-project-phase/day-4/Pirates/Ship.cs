using System;
using System.Collections.Generic;

namespace Pirates
{
    class Ship
    {
        private List<Pirate> crew;
        internal List<Pirate> Crew { get => crew; set => crew = value; }

        private Pirate captain;
        internal Pirate Captain { get => captain; set => captain = value; }

        public Ship()
        {
            this.Crew = new List<Pirate>();
            this.FillShip();
        }

        public void FillShip()
        {
            this.Captain = new Pirate();
            for (int i = 0; i < new Random().Next(50) + 1; i++)
            {
                Crew.Add(new Pirate());
            }
        }

        public void IntroduceYourCaptainAndCrew()
        {
            Console.WriteLine($"The captain has drunk {this.Captain.LevelOfIntoxication} rounds of rum today.");
            Console.WriteLine(this.Captain.IsDead ? "The captain is dead." : this.Captain.IsPassedOut ? "The captain has passed out." : "The captain is in really good shape.");
            Console.WriteLine($"The ship has {GetAlivePirates().Count} alive members in the crew.");
        }

        public List<Pirate> GetAlivePirates()
        {
            List<Pirate> alivePirates = new List<Pirate>();
            foreach (Pirate pirate in Crew)
            {
                if(!pirate.IsDead)
                {
                    alivePirates.Add(pirate);
                }
            }
            return alivePirates;
        }

        public bool Battle(Ship anotherShip)
        {
            if(this.CalculateScore() >= anotherShip.CalculateScore())
            {
                anotherShip.HaveAParty();
                this.SufferLosses(new Random().Next(this.Crew.Count));
                return false;
            } else
            {
                this.HaveAParty();
                anotherShip.SufferLosses(new Random().Next(this.Crew.Count));
                return true;
            }

        }

        public int CalculateScore()
        {
            return this.GetAlivePirates().Count - this.Captain.LevelOfIntoxication;
        }

        public void SufferLosses(int numberOfDeaths)
        {
            for (int i = 0; i < numberOfDeaths; i++)
            {
                if (!Crew[i].IsDead)
                {
                    Crew[i].Die();
                }
                else
                {
                    numberOfDeaths++;
                }
            }
        }

        public void HaveAParty()
        {
            for (int i = 0; i < new Random().Next(5); i++)
            {
                this.Captain.DrinkSomeRum();
            }

            foreach (Pirate pirate in Crew)
            {
                for (int i = 0; i < new Random().Next(5); i++)
                {
                    pirate.DrinkSomeRum();
                }
            }
        }
    }
}
