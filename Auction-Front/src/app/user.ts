export interface user{
  id: number,
  name: string,
  password: string,
  lots: Lot[];
}

export interface Lot {
  id: number;
  title: string;
  description: string;
  startTime: string;
  endTime: string;
  startingPrice: {
    id: number;
    price: number;
  };
}
