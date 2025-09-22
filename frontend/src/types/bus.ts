// Tipos para la API de Buses
export interface Bus {
  id: number;
  number: string;
  plate: string;
  createdAt: string;
  features: string;
  active: boolean;
  brandId: number;
  brandName: string;
}

export interface PageBusResponse {
  content: Bus[];
  pageable: {
    pageNumber: number;
    pageSize: number;
    sort: {
      sorted: boolean;
      ascending: boolean;
      properties: string[];
    };
  };
  totalElements: number;
  totalPages: number;
  first: boolean;
  last: boolean;
  numberOfElements: number;
}

export interface PaginationProps {
  currentPage: number;
  totalPages: number;
  onPageChange: (page: number) => void;
}