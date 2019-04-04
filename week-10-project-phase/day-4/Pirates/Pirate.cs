using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pirates
{
    class Pirate
    {
        private int levelOfIntoxication;
        public int LevelOfIntoxication { get; set; }

        private bool isDead;
        public bool IsDead { get; set; }

        private Parrot parrot;
        public Parrot Parrot { get; set; }

        public Pirate()
        {
            this.levelOfIntoxication = 0;
            this.isDead = false;
        }

        public void DrinkSomeRum()
        {
            this.levelOfIntoxication++;
        }

        public void HowsItGoingMate()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }

            if(LevelOfIntoxication <= 4)
            {
                Console.WriteLine("Pour me anudder!");
            } else
            {
                Console.WriteLine("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                this.Sleep();
            }
        }

        private void Sleep()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }
            this.LevelOfIntoxication = 0;
        }

        private void Die()
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }
            this.IsDead = true;
        }

        private void Brawl(Pirate pirate)
        {
            if (this.IsDead)
            {
                Console.WriteLine("He is dead.");
                return;
            }

            if (pirate.IsDead)
            {
                Console.WriteLine("The other pirate is dead.");
                return;
            }

            switch (new Random().Next(1, 4))
            {
                case 1:
                    this.Die();
                    Console.WriteLine("He is dead.");
                    break;
                case 2:
                    pirate.Die();
                    Console.WriteLine("The other pirate is dead.");
                    break;
                case 3:
                    this.Die();
                    pirate.Die();
                    Console.WriteLine("They are both dead.");
                    break;
            }
        }

        public void AddParrot(Parrot parrot)
        {
            Parrot = parrot;
        }
    }
}
